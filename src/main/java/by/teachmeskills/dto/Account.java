package by.teachmeskills.dto;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Account {

    private String accountName;
    private String website;
    private String phone;
    private String type;
    private String industry;
}
