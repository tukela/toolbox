package com.hl.kit.data.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class T_user {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String user_type;
  private String mobilephone;
  private String password;
  private String identification_state;
  private String vetoed_cause;
  private String realname;
  private String certificate_type;
  private String certificate_no;
  private String electronic_signature_path;
  private Long electronic_signature_model;
  private String electronic_signature_color;
  private java.sql.Timestamp register_date;
  private java.sql.Timestamp identification_date;
  private Long identification_user;
  private String user_quality;
  private String forbidden;
  private String photo_path;
  private Long sign_count;
  private Long login_count;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUser_type() {
    return user_type;
  }

  public void setUser_type(String user_type) {
    this.user_type = user_type;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public void setMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIdentification_state() {
    return identification_state;
  }

  public void setIdentification_state(String identification_state) {
    this.identification_state = identification_state;
  }

  public String getVetoed_cause() {
    return vetoed_cause;
  }

  public void setVetoed_cause(String vetoed_cause) {
    this.vetoed_cause = vetoed_cause;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getCertificate_type() {
    return certificate_type;
  }

  public void setCertificate_type(String certificate_type) {
    this.certificate_type = certificate_type;
  }

  public String getCertificate_no() {
    return certificate_no;
  }

  public void setCertificate_no(String certificate_no) {
    this.certificate_no = certificate_no;
  }

  public String getElectronic_signature_path() {
    return electronic_signature_path;
  }

  public void setElectronic_signature_path(String electronic_signature_path) {
    this.electronic_signature_path = electronic_signature_path;
  }

  public Long getElectronic_signature_model() {
    return electronic_signature_model;
  }

  public void setElectronic_signature_model(Long electronic_signature_model) {
    this.electronic_signature_model = electronic_signature_model;
  }

  public String getElectronic_signature_color() {
    return electronic_signature_color;
  }

  public void setElectronic_signature_color(String electronic_signature_color) {
    this.electronic_signature_color = electronic_signature_color;
  }

  public java.sql.Timestamp getRegister_date() {
    return register_date;
  }

  public void setRegister_date(java.sql.Timestamp register_date) {
    this.register_date = register_date;
  }

  public java.sql.Timestamp getIdentification_date() {
    return identification_date;
  }

  public void setIdentification_date(java.sql.Timestamp identification_date) {
    this.identification_date = identification_date;
  }

  public Long getIdentification_user() {
    return identification_user;
  }

  public void setIdentification_user(Long identification_user) {
    this.identification_user = identification_user;
  }

  public String getUser_quality() {
    return user_quality;
  }

  public void setUser_quality(String user_quality) {
    this.user_quality = user_quality;
  }

  public String getForbidden() {
    return forbidden;
  }

  public void setForbidden(String forbidden) {
    this.forbidden = forbidden;
  }

  public String getPhoto_path() {
    return photo_path;
  }

  public void setPhoto_path(String photo_path) {
    this.photo_path = photo_path;
  }

  public Long getSign_count() {
    return sign_count;
  }

  public void setSign_count(Long sign_count) {
    this.sign_count = sign_count;
  }

  public Long getLogin_count() {
    return login_count;
  }

  public void setLogin_count(Long login_count) {
    this.login_count = login_count;
  }
}
