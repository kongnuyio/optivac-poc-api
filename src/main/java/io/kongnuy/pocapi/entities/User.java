package io.kongnuy.pocapi.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "FIRSTNAME", nullable = false)
  private String firstname;

  @Column(name = "LASTNAME", nullable = false)
  private String lastname;

  @Column(name = "UUID", unique = true)
  private String uuid;

  @Lob
  @Column(name = "FCMTOKEN")
  private String fcmToken;

  @Column(name = "EXTERNALUUID", unique = true)
  private String externalUuid;

  @Column(name = "PLATFORM", nullable = false)
  private String platform;

  @Column(name = "NOTIFY_ME_ON_NEW_BLOG_ARTICLE", nullable = false)
  private boolean notifyMeOnNewBlogArticle;

  @Column(name = "NOTIFY_ME_ON_NEW_BONPLAN", nullable = false)
  private boolean notifyMeOnNewBonPlan;

  @Column(name = "NOTIFY_ME_ON_CARTEPRO_EXPIRATION", nullable = false)
  private boolean notifyMeOnCarteProExpiration;

  @Column(name = "NOTIFY_ME_ON_NEW_RIGHT_ARTICLE", nullable = false)
  private boolean notifyMeOnNewRightArticle;

  @Lob
  @Column(name = "ROWINDEX")
  private String rowIndex;
}
