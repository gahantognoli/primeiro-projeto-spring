package br.com.gahantognoli.ioc;

import org.springframework.stereotype.Service;

@Service
public class MeuComponent {
  public String chamarComponent() {
    return "Chamando meu componente!";
  }
}
