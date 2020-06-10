package io.swagger.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.customizacao.service.ContaService;
import io.swagger.customizacao.util.RespostasUtil;
import io.swagger.model.Extrato;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-27T23:17:19.797Z")

@Controller
public class ExtratoApiController implements ExtratoApi {

    @Autowired
	private ContaService contaService;
    
    @Autowired
    private RespostasUtil respostasUtil;
	
	private static final Logger log = LoggerFactory.getLogger(ExtratoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExtratoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Extrato> consultaExtrato(@ApiParam(value = "",required=true) 
    @PathVariable("agencia") Integer agencia,@ApiParam(value = "",required=true) 
    @PathVariable("numero") Long numero,@ApiParam(value = "",required=true) 
    @PathVariable("digito") Integer digito,@ApiParam(value = "" ,required=true) 
    @RequestHeader(value="Authorization", required=true) String authorization) {
        
    try {
		
    	return contaService.consultaExtrato(authorization, agencia, numero, digito);
	} catch (Exception e) {
		return respostasUtil.getErroInternoExtrato(respostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_EXTRATO);
	}
    
    }
}
