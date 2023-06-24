package com.music.restful.foundation.uuid;

import java.util.UUID;

import javax.persistence.GenerationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Entity
@Getter
@Table(name = "common_uuid")
@Inheritance(strategy = InheritanceType.JOINED)
public class CommonUUID {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uid;
	
}
