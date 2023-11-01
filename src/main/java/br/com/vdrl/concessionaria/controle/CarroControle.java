
package br.com.vdrl.concessionaria.controle;

import br.com.vdrl.concessionaria.entidade.Carro;
import br.com.vdrl.concessionaria.modelo.RespostaModelo;
import br.com.vdrl.concessionaria.servico.CarroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class CarroControle {
    @GetMapping("/")
    public String rota(){
        return "teste";
    }
    
    @Autowired
    private CarroServico carroServico;
    
    @GetMapping("/carros")
    public Iterable<Carro>listar(){
        return carroServico.listar();
    }
    
    @PostMapping("/carro")
    public ResponseEntity<?> salvar(@RequestBody Carro carro){
        return carroServico.salvar(carro,"Salvar");
    }
    
    @PutMapping("/carro/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Carro carro){
        return carroServico.salvar(carro, "atualizar");
    }
    
    @DeleteMapping("/carro/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id){
        return carroServico.remover(id);
    }
    
}
