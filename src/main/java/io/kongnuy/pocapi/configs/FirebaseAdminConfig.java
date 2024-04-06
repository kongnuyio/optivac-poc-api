package io.kongnuy.pocapi.configs;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

import io.kongnuy.pocapi.dtos.properties.FirebaseProperties;

@Configuration
@EnableConfigurationProperties(FirebaseProperties.class)
public class FirebaseAdminConfig {
  
  private final FirebaseProperties firebaseProperties;

  public FirebaseAdminConfig(final FirebaseProperties firebaseProperties) {
    this.firebaseProperties = firebaseProperties;
  }

  @Bean
  FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
    return FirebaseMessaging.getInstance(firebaseApp);
  }

  @Bean
  FirebaseApp firebaseApp(GoogleCredentials credentials) {
    FirebaseOptions options = FirebaseOptions.builder()
      .setCredentials(credentials)
      .build();

    return FirebaseApp.initializeApp(options);
  }

  @Bean
  GoogleCredentials googleCredentials() throws IOException {
    if (firebaseProperties.getServiceAccount() != null) {
      try (InputStream is = firebaseProperties.getServiceAccount().getInputStream()) {
        return GoogleCredentials.fromStream(is);
      }
    } 
    else {
      return GoogleCredentials.getApplicationDefault();
    }
  }
}
