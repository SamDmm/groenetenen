package be.vdab.groenetenen.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.sun.istack.NotNull;

import be.vdab.groenetenen.valueobjects.Adres;

@Entity
@Table(name = "filialen")
public class Filiaal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@SafeHtml
	private String naam;
	private boolean hoofdFiliaal;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@PositiveOrZero
	@Digits(integer = 10, fraction = 2)
	private BigDecimal waardeGebouw;
	@DateTimeFormat(style = "S-")
	@NotNull
	private LocalDate inGebruikName;
	@Valid
	@Embedded
	private Adres adres;
	@Version
	private long versie;
	@OneToMany(mappedBy = "filiaal")
	private Set<Werknemer> werknemers;
	
	public Filiaal(String naam, boolean hoofdFiliaal, BigDecimal waardeGebouw, LocalDate inGebruikName, Adres adres) {
		this.naam = naam;
		this.hoofdFiliaal = hoofdFiliaal;
		this.waardeGebouw = waardeGebouw;
		this.inGebruikName = inGebruikName;
		this.adres = adres;
	}
	public Filiaal() {
	}

	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public boolean isHoofdFiliaal() {
		return hoofdFiliaal;
	}
	public BigDecimal getWaardeGebouw() {
		return waardeGebouw;
	}
	public LocalDate getInGebruikName() {
		return inGebruikName;
	}
	public Adres getAdres() {
		return adres;
	}
	public long getVersie() {
		return versie;
	}
	public Set<Werknemer> getWerknemers() {
		return Collections.unmodifiableSet(werknemers);
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void setHoofdFiliaal(boolean hoofdFiliaal) {
		this.hoofdFiliaal = hoofdFiliaal;
	}
	public void setWaardeGebouw(BigDecimal waardeGebouw) {
		this.waardeGebouw = waardeGebouw;
	}
	public void setInGebruikName(LocalDate inGebruikName) {
		this.inGebruikName = inGebruikName;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	public void setVersie(long versie) {
		this.versie = versie;
	}
}
