package com.enset.schoolcloud.service;

import codex.bookerapi.config.JwtService;
import codex.bookerapi.entity.auth.Auth;
import codex.bookerapi.entity.entreprise.UpgrapdePlanType;
import codex.bookerapi.responseBody.AuthenticationResponse;
import codex.bookerapi.entity.auth.UserRole;
import codex.bookerapi.entity.auth.ValidationToken;
import codex.bookerapi.entity.entreprise.Entreprise;
import codex.bookerapi.entity.user.User;
import codex.bookerapi.repository.AuthRepository;
import codex.bookerapi.repository.EntrepriseRepository;
import codex.bookerapi.repository.UserRepository;
import codex.bookerapi.repository.ValidationRepository;
import codex.bookerapi.dto.AuthenticationDto;
import codex.bookerapi.dto.RegisterEntrepriseDto;
import codex.bookerapi.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService  {
    private final UserRepository repository;
    private final AuthRepository authRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ValidationRepository validationRepository;
    private final ValidationService validationService;

    public AuthenticationResponse registerUser(RegisterDto request) {
        Instant created_at = Instant.now();
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .country_code(request.getCountry_code())
                .phone(request.getPhone())
                .gender(request.getGender())
                .created_at(created_at)
                .isVerified(false)
                .password(passwordEncoder.encode((request.getPassword())))
                .role(UserRole.USER)
                .build();

        if (!user.getEmail().contains("@") || !user.getEmail().contains(".")){
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .message("Email user is invalid !")
                    .token("null")
                    .build();
        }
        else {
            var auth = Auth.builder()
                    .firstname(request.getFirstname())
                    .email(request.getEmail())
                    .phone_number(request.getPhone())
                    .created_at(created_at)
                    .gender(request.getGender())
                    .role(user.getRole())
                    .user(user)
                    .build();

            boolean userOptional = repository.findByEmail(user.getEmail()).isPresent();
            if (userOptional) {
                return AuthenticationResponse.builder()
                        .message("user already exist")
                        .success(false)
                        .error(true)
                        .token("null")
                        .build();
            }

            //save user in a repository user database
            var currentUser = this.repository.save(user);
            validationService.registerValidation(currentUser);

            //save auth user in a repository auth database;
            authRepository.save(auth);

            //generate a jwtToken
            var jwtToken = jwtService.generateToken(user);
            var user_id = user.getId();

            //return an AuthenticationResponse
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .error(false)
                    .message("User created successfully !")
                    .success(true)
                    .id(user_id)
                    .build();
        }
    }
    public AuthenticationResponse registerEntreprise(RegisterEntrepriseDto request) {
        Instant created_at  = Instant.now();
        var entreprise = Entreprise.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .entreprise_name(request.getEnterprise_name())
                .password(passwordEncoder.encode((request.getPassword())))
                .plan(UpgrapdePlanType.FREE)
                .followers(0)
                .gender(request.getGender())
                .country_code(request.getCountry_code())
                .entreprise_name(request.getEntreprise_name())
                .isVerified(false)
                .role(UserRole.ENTREPRISE)
                .created_at(created_at)
                .build();

        var auth = Auth.builder()
                .firstname(request.getFirstname())
                .email(request.getEmail())
                .created_at(created_at)
                .role(entreprise.getRole())
                .build();


        if (entrepriseRepository.findByEmail(entreprise.getEmail()).isPresent()) {
            return AuthenticationResponse.builder()
                    .message("user already exist")
                    .success(false)
                    .token("null")
                    .error(true)
                    .build();
        } else {
            var currentUser = entrepriseRepository.save(entreprise);
            //validationService.registerEntrepriseValidation(currentUser);
            authRepository.save(auth);
            var jwtToken = jwtService.generateToken(entreprise);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .error(false)
                    .success(true)
                    .enterprise(entreprise)
                    .message("Enterprise created successfully !")
                    .id(entreprise.getId())
                    .build();
        }
    }
    public AuthenticationResponse authenticate(AuthenticationDto request) {
        var user = repository.findByEmail((request.getEmail()))
                .orElseThrow();

        // verify if user is verified or not
        if (!user.getIsVerified()){
            return AuthenticationResponse.builder()
                    .success(false)
                    .message("User is not verified !")
                    .error(true)
                    .build();
        }
        else {
                // left spring to authenticate my user
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );
                //create a jwtToken
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                        .error(false)
                        .message(user.getFirstname() + " " + " is connected successfully")
                        .token(jwtToken)
                        .success(true)
                        .id(user.getId())
                        .build();
        }

    }
    public AuthenticationResponse authenticate_enterprise(AuthenticationDto request) {
        var enterprise = entrepriseRepository.findByEmail((request.getEmail()));

        if (enterprise.isEmpty()) {
            return AuthenticationResponse.builder()
                    .error(true)
                    .message(request.getEmail()+ " " + " doesn't exist !")
                    .success(false)
                    .build();
        } else {
            try {
                var auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                enterprise.get().getEmail(),
                                request.getPassword()
                        )
                );
                var jwtToken = jwtService.generateToken(enterprise.get());
                return AuthenticationResponse.builder()
                        .error(false)
                        .message(enterprise.get().getFirstname() + " " + " is connected successfully")
                        .token(jwtToken)
                        .success(true)
                        .id(enterprise.get().getId())
                        .enterprise(enterprise.get())
                        .build();
            } catch (BadCredentialsException e) {
                return AuthenticationResponse.builder()
                        .error(true)
                        .message("Invalid password")
                        .success(false)
                        .build();
            }
        }
    }

    public AuthenticationResponse activation(Map<String, String> code) {
        ValidationToken validation = validationService.readCode(code.get("code"));
        if (Instant.now().isAfter(validation.getExpired_at())) {
            throw new RuntimeException("Your otp_code are expired !");
        }
        User activeUser =
                repository.findById(validation
                        .getUser().getId())
                        .orElseThrow(() -> new RuntimeException(
                        "User unknown"));
        activeUser.setIsVerified(true);
        validation.setActivated_at(Instant.now());
        this.validationRepository.save(validation);
        this.repository.save(activeUser);
        return AuthenticationResponse.builder()
                .message("User verified successfully")
                .success(true)
                .build();
    }
    public AuthenticationResponse activation_entreprise(Map<String, String> code) {
        ValidationToken validation = validationService.readCode(code.get("code"));
        if (Instant.now().isAfter(validation.getExpired_at())) {
            throw new RuntimeException("Your otp_code are expired !");
        }
        Entreprise activeUser =
                entrepriseRepository.findById(validation
                                .getEntreprise().getId())
                        .orElseThrow(() -> new RuntimeException(
                                "User unknown"));
        activeUser.setIsVerified(true);
        validation.setActivated_at(Instant.now());
        this.validationRepository.save(validation);
        this.entrepriseRepository.save(activeUser);
        return AuthenticationResponse.builder()
                .message("User verified successfully")
                .build();
    }
    public AuthenticationResponse updateOtp(Map<String,String> email) {
        var user = repository.findByEmail(email.get("email"));
        if (user.isEmpty())
        {
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .id("null")
                    .message("User doesn't exist !")
                    .token("null")
                    .build();
        }
        var current_user_id = user.get().getId();
        var validation_current_user = validationRepository.findByUserId(current_user_id).orElseThrow();
        Instant created_at = Instant.now();
        Instant expired_at = created_at.plus(10, ChronoUnit.MINUTES);
        validation_current_user.setExpired_at(expired_at);
        validation_current_user.setCreated_at(created_at);
        //create a new random code
        Random random = new Random();
        int randomCode = random.nextInt(999999);
        String code = String.format("%06d", randomCode);

        validation_current_user.setCode(code);
        validationRepository.save(validation_current_user);
        //send message otp code via mail

        //create a token
        var jwtToken = jwtService.generateToken(user.get());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Token updated successfully !")
                .success(true)
                .id(current_user_id)
                .error(false)
                .build();
    }
    public AuthenticationResponse updateOtpEntreprise(Map<String, String> email) {
        var enterprise = entrepriseRepository.findByEmail(email.get("email"));
        if (enterprise.isEmpty())
        {
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .id("null")
                    .message("User doesn't exist !")
                    .token("null")
                    .build();
        }
        var current_enterprise_id = enterprise.get().getId();
        //System.out.println(current_enterprise_id);
        var validation_current_enterprise =
                validationRepository.findByEntrepriseId(current_enterprise_id);

        if (validation_current_enterprise.isEmpty())
        {
                return AuthenticationResponse.builder()
                        .error(true)
                        .success(false)
                        .id("null")
                        .message("enterprise doesn't exist !")
                        .token("null")
                        .build();
        }

        Instant created_at = Instant.now();
        Instant expired_at = created_at.plus(10, ChronoUnit.MINUTES);
        validation_current_enterprise.get().setExpired_at(expired_at);
        validation_current_enterprise.get().setCreated_at(created_at);
        //create a new random code
        Random random = new Random();
        int randomCode = random.nextInt(999999);
        String code = String.format("%06d", randomCode);

        validation_current_enterprise.get().setCode(code);
        validationRepository.save(validation_current_enterprise.get());
        //send otp via mail !

        /*----------------------------------------------------*/

        var jwtToken = jwtService.generateToken(enterprise.get());
        //send message otp code via mail
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Token updated successfully !")
                .error(false)
                .success(true)
                .id(current_enterprise_id)
                .build();
    }

    public AuthenticationResponse forgotPasswordUser(Map<String, String> email) {
        var user = repository.findByEmail(email.get("email"));
        if (user.isEmpty())
        {
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .id("null")
                    .message("User doesn't exist !")
                    .token("null")
                    .build();
        }
        var current_user_id = user.get().getId();
        var validation_current_user = validationRepository.findByUserId(current_user_id).orElseThrow();
        Instant created_at = Instant.now();
        Instant expired_at = created_at.plus(10, ChronoUnit.MINUTES);
        validation_current_user.setExpired_at(expired_at);
        validation_current_user.setCreated_at(created_at);
        //create a new random code
        Random random = new Random();
        int randomCode = random.nextInt(999999);
        String code = String.format("%06d", randomCode);

        validation_current_user.setCode(code);
        validationRepository.save(validation_current_user);
        //send message otp code via mail

        //create a token
        var jwtToken = jwtService.generateToken(user.get());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Token sent successfully!")
                .success(true)
                .id(current_user_id)
                .error(false)
                .build();
    }

    public AuthenticationResponse forgotPasswordEnterprise(Map<String, String> email) {
        var enterprise = entrepriseRepository.findByEmail(email.get("email"));
        if (enterprise.isEmpty())
        {
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .id("null")
                    .message("User doesn't exist !")
                    .token("null")
                    .build();
        }
        var current_enterprise_id = enterprise.get().getId();
        //System.out.println(current_enterprise_id);
        var validation_current_enterprise =
                validationRepository.findByEntrepriseId(current_enterprise_id);

        if (validation_current_enterprise.isEmpty())
        {
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .id("null")
                    .message("enterprise doesn't exist !")
                    .token("null")
                    .build();
        }

        Instant created_at = Instant.now();
        Instant expired_at = created_at.plus(10, ChronoUnit.MINUTES);
        validation_current_enterprise.get().setExpired_at(expired_at);
        validation_current_enterprise.get().setCreated_at(created_at);
        //create a new random code
        Random random = new Random();
        int randomCode = random.nextInt(999999);
        String code = String.format("%06d", randomCode);

        validation_current_enterprise.get().setCode(code);
        validationRepository.save(validation_current_enterprise.get());
        //send otp via mail !

        /*----------------------------------------------------*/

        var jwtToken = jwtService.generateToken(enterprise.get());
        //send message otp code via mail
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Token sent successfully!")
                .error(false)
                .success(true)
                .id(current_enterprise_id)
                .build();
    }

    public AuthenticationResponse resetPasswordUser(Map<String, String> request) {
        var user = repository.findById(request.get("id"));
        if (user.isEmpty())
        {
            return AuthenticationResponse.builder()
                    .error(true)
                    .success(false)
                    .id("null")
                    .message("User doesn't exist !")
                    .token("null")
                    .build();
        }
        var current_user_id = user.get().getId();
        var validation_current_user = validationRepository.findByUserId(current_user_id).orElseThrow();
        if (Instant.now().isAfter(validation_current_user.getExpired_at())) {
            throw new RuntimeException("Your otp_code are expired !");
        }
        User activeUser =
                repository.findById(validation_current_user
                        .getUser().getId())
                        .orElseThrow(() -> new RuntimeException(
                                "User unknown"));
        activeUser.setPassword(passwordEncoder.encode(request.get("password")));
        validation_current_user.setActivated_at(Instant.now());
        this.validationRepository.save(validation_current_user);
        this.repository.save(activeUser);
        return AuthenticationResponse.builder()
                .message("Password updated successfully")
                .success(true)
                .build();
    }

    public User getUserById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Entreprise getEntrepriseById(String entrepriseId) {
        return entrepriseRepository.findById(entrepriseId).orElseThrow();
    }

    //public AuthenticationResponse logoutUser(Map<String, String> request) {
    //}
}