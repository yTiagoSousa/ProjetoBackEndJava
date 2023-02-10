package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository_old {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de Produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo que retorna o produto pelo seu ID.
     * @param id do produto que sera localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> Objects.equals(produto.getId(), id))
                .findFirst();
    }
    /**
     * Metodo para adicionar produto na lista
     * @param produto produto que sera adicionado
     * @return retorna o produto que foi adicionado
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
    
        return produto;
    }

    /**
     * Metodo para deletar produto por ID
     * @param id do produto para ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> Objects.equals(produto.getId(), id));
    }

    /**
     * 
     * @param produto que ser atualizado
     * @return o produto apos ser atualizado
     */
    public Produto atualizar(Produto produto){
       Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

       if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto nao encontrado");
       } 
       
        this.deletar(produto.getId());
        produtos.add(produto);

        return produto;
    }
}

   