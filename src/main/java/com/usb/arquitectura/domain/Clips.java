package com.usb.arquitectura.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "clips", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clips implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idclip", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclip;

    private String subtitulos;

    private String url;
}
