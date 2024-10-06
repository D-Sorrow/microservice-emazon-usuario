package com.emazon.user.domain.api.usecase;


import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.exception.AgeNotValidException;
import com.emazon.user.domain.exception.EmailInvalidException;
import com.emazon.user.domain.exception.InvalidDocumentException;
import com.emazon.user.domain.exception.PhoneNumberInvalidException;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.IEncoderPort;
import com.emazon.user.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.regex.Pattern;

import static com.emazon.user.domain.constants.ConstantsDomain.AGE_NO_VALID;


public class UserUseCase implements IUserServicePort {

    public final IUserPersistencePort userPersistencePort;
    public final IEncoderPort encoderPort;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PHONE_REGEX = "^\\+?[0-9]{1,13}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public UserUseCase(IUserPersistencePort userPersistencePort, IEncoderPort encoderPort) {
        this.userPersistencePort = userPersistencePort;
        this.encoderPort = encoderPort;
    }
    @Override
    public void saveUser(User user) {

        if(Period.between(user.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate(), LocalDate.now()).getYears() < AGE_NO_VALID){
            throw new AgeNotValidException();
        }
        if (!EMAIL_PATTERN.matcher(user.getUserEmail()).matches()){
            throw new EmailInvalidException();
        }
        if (!PHONE_PATTERN.matcher(user.getUserPhoneNumber()).matches()){
            throw new PhoneNumberInvalidException();
        }
        if (user.getIdentityDocument() == null ) {
            throw new InvalidDocumentException();
        }
        user.setUserPassword(encoderPort.encode(user.getUserPassword()));
        userPersistencePort.saveUser(user);
    }

}
