package com.bekiristek.bankingapp.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /**
     * Aktif/Pasif
     * <p>
     * Kayıt silinmişse false değilse true;
     */
    @Builder.Default
    @Column(columnDefinition = "boolean not null default true ")
    private boolean active = true;

    /**
     * Kayıt versiyon bilgisi
     */
    @Builder.Default
    @Version
    @Column(columnDefinition = "int not null default 0 ")
    private Integer version = 0;

    private LocalDateTime createdDateTime;

}
