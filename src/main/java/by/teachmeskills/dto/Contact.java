package by.teachmeskills.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Contact {

    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String salutation;
    private String contactName;
    private Account account;
}
