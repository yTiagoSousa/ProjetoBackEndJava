package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository_old;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository_old produtoRepository;
    /**
    * Metodo para retornar uma lista de Produtos
    * @return lista de produtos
    */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

     /**
     * Metodo que retorna o produto pelo seu ID.
     * @param id do produto que sera localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

     /**
     * Metodo para adicionar produto na lista
     * @param produto produto que sera adicionado
     * @return retorna o produto que foi adicionado
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo para deletar produto por ID
     * @param id do produto para ser deletado
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

     /**
     * 
     * @param produto que ser atualizado
     * @return o produto apos ser atualizado
     */
    public Produto atualizar(Integer id, Produto produto){
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }
}
