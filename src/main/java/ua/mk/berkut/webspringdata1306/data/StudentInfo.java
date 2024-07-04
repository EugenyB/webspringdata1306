package ua.mk.berkut.webspringdata1306.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Student}
 */
public interface StudentInfo {
    Long getId();

//    String getFirstName();
//
//    String getLastName();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    Integer getAge();
}