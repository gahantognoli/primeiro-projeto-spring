package br.com.gahantognoli.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meu-controller")
public class MeuControllerComponent {

  @Autowired
  MeuComponent meuComponent;

  @GetMapping
  public String chamarComponent(){
    return meuComponent.chamarComponent();
  }
}
