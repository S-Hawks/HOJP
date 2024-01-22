package com.fia.backend;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Item {

    @Id
    private String id;

    private String description;

    private ItemStatus status = ItemStatus.TODO;

    @CreatedDate
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();
}
