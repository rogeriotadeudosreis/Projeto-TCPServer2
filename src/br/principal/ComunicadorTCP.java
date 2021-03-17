/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author roger
 */
public class ComunicadorTCP {

    Socket conexao;
    ServerSocket ouvir;
    DataInputStream receberMsg;
    DataOutputStream enviarMsg;

    // Construtor cliente
    public ComunicadorTCP(String ipServer, int porta) throws IOException {

        this.conexao = new Socket(ipServer, porta);
        this.receberMsg = new DataInputStream(this.conexao.getInputStream());
        this.enviarMsg = new DataOutputStream(this.conexao.getOutputStream());

    }

    // Construtor servidor
    public ComunicadorTCP(int porta) throws IOException {
        this.ouvir = new ServerSocket(porta);
        this.conexao = ouvir.accept();
        this.receberMsg = new DataInputStream(this.conexao.getInputStream());
        this.enviarMsg = new DataOutputStream(this.conexao.getOutputStream());

    }
    
    // enviar mensagem
    public void enviarMensagem(String mensagem)throws IOException{
        this.enviarMsg.writeUTF(mensagem);
        this.enviarMsg.flush();
    }
    
    // recebendo mensagem
    public String receberMensagem()throws IOException{
      return this.receberMsg.readUTF();
    } 
    
    
}
