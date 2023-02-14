package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;
import com.teste.primeiroexemplo.repository.ProdutoRepository;
import com.teste.primeiroexemplo.shared.ProdutoDTO;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    /**
    * Metodo para retornar uma lista de Produtos
    * @return lista de produtos
    */
    public List<ProdutoDTO> obterTodos(){
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());
    }

     /**
     * Metodo que retorna o produto pelo seu ID.
     * @param id do produto que sera localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + "não encontrado"); // TEM ALGO ERRADO
        }else{
        ProdutoDTO dto = new ModelMapper().map(produto, ProdutoDTO.class);
        return Optional.of(dto);
        }
    }

     /**
     * Metodo para adicionar produto na lista
     * @param produto produto que sera adicionado
     * @return retorna o produto que foi adicionado
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){  
        produtoDto.setId(null);
        
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());
        
        return produtoDto;
    }

    /**
     * Metodo para deletar produto por ID
     * @param id do produto para ser deletado
     */
    public void deletar(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar produto com id " + id + " Não encontrado" );
        }
        produtoRepository.deleteById(id);
    }

     /**
     * @param id do produto que sera atualizado
     * @param produto atualizado
     * @return o produto apos ser atualizado
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){
        produtoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produtoRepository.save(produto);
        return produtoDto;
    }
}
