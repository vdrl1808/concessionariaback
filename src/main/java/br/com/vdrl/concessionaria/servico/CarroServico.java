package br.com.vdrl.concessionaria.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vdrl.concessionaria.entidade.Carro;
import br.com.vdrl.concessionaria.modelo.RespostaModelo;
import br.com.vdrl.concessionaria.repositorio.CarroRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service

public class CarroServico {
    @Autowired
    private CarroRepositorio carroRepositorio;
    
    public Iterable<Carro> listar(){
        return carroRepositorio.findAll();
    }

    
    @Autowired
    private RespostaModelo respostaModelo;
    
    
    public ResponseEntity<?> salvar(Carro carro, String acao){
        
        if (carro.getNome().equals("")){
            respostaModelo.setMensagem("O Nome do carro é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else if (carro.getModelo().equals("")){
            respostaModelo.setMensagem("O Modelo do carro é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else if (carro.getMarca().equals("")){
            respostaModelo.setMensagem("A Marca do carro é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }
        else{
            if (acao.equals("Salvar"))
                return new ResponseEntity<Carro>(carroRepositorio.save(carro),HttpStatus.CREATED);
            else
                return new ResponseEntity<Carro>(carroRepositorio.save(carro),HttpStatus.OK);     
        }
    
    }
    
    public ResponseEntity<RespostaModelo> remover(Long id){
        carroRepositorio.deleteById(id);
        respostaModelo.setMensagem("Removido com sucesso");
        return new  ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.OK);
    }
    
}
