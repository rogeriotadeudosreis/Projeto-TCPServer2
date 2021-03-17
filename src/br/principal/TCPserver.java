/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.principal;

import java.io.IOException;

/**
 *
 * @author roger
 */
public class TCPserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int porta = 6789;
        String mensagem;
        ComunicadorTCP comunicacao = new ComunicadorTCP(porta);

        while (true) {
            mensagem = comunicacao.receberMensagem();
            //salvar em uma arquivo.txt ou qualquer outra operação necessária no PI
            System.out.println("Resposta : " + mensagem);
            mensagem = "ok > " + mensagem.toUpperCase();
            comunicacao.enviarMensagem(mensagem);

        }
        

    }

}
