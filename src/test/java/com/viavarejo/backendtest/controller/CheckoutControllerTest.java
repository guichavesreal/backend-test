package com.viavarejo.backendtest.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.viavarejo.backendtest.dto.CheckoutRequestDTO;
import com.viavarejo.backendtest.dto.CheckoutResponseDTO;
import com.viavarejo.backendtest.dto.CondicaoPagamentoDTO;
import com.viavarejo.backendtest.dto.ProdutoDTO;
import com.viavarejo.backendtest.service.CheckoutService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CheckoutControllerTest {

    @InjectMocks
    private CheckoutService service;
    
	CheckoutRequestDTO request = new CheckoutRequestDTO();
    
    @Test
    public void CheckoutTest() {
    	
    	CheckoutService mockService = org.mockito.Mockito.mock(CheckoutService.class);
    	
    	ProdutoDTO produto = new ProdutoDTO();
    	
    	produto.setCodigo(1);
    	produto.setNome("Produto Teste");
    	produto.setValor(200.00);
    	
    	CondicaoPagamentoDTO condicao = new CondicaoPagamentoDTO();
    	
    	condicao.setQtdeParcelas(1);
    	condicao.setValorEntrada(100.00);
    	    	
    	request.setCondicaoPagamento(condicao);
    	request.setProduto(produto);
    	
    	List<CheckoutResponseDTO> response = new ArrayList<CheckoutResponseDTO>();
    	when(mockService.calculoPrestacoes(request)).thenReturn(response);
    	
    	assertNotNull(response);	
    	
    }
    

}
