package br.com.gahantognoli.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class PrimeiraController {

  @GetMapping("{id}")
  public String hello(@PathVariable String id) {
    return "Hello " + id + "!";
  }

  @GetMapping("/query")
  public String queryParams(@RequestParam String id){
    return "Parametro recebido: " + id;
  }

  @GetMapping("/query2")
  public String queryParams2(@RequestParam Map<String, String> params) {
    return "Parametro recebido: " + params.entrySet();
  }

  @PostMapping
  public String post(@RequestBody Usuario teste){
    return "Post: " + teste.teste();
  }

  @PostMapping("/headers")
  public String fromHeaders(@RequestHeader("teste") String teste) {
    return "Header: " + teste;
  }

  @PostMapping("/list-headers")
  public String listHeaders(@RequestHeader Map<String, String> headers) {
    return "Headers: " + headers.entrySet();
  }

  @GetMapping("/response-entity/{id}")
  public ResponseEntity<Object> responseEntity(@PathVariable Long id) {
    var usuario = new Usuario("Teste2");

    if(id > 5){
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(usuario);
    }
    else{
      return ResponseEntity
        .badRequest()
        .body("Usuario não encontrado");
    }
  }

  record Usuario(String teste) {}
}
