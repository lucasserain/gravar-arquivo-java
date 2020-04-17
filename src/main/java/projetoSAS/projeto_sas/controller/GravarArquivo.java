package projetoSAS.projeto_sas.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Classe responsavel por gravar arquivos
public class GravarArquivo {
	
	//Diretorio onde vai ser salvo ( ficar atento com permissao de gravacao no dir escolhido)
	private String diretorioArquivo = "C:\\temp/teste.txt";
	//ArrayList que vai receber as strings a serem gravadas no arquivo
	private List<String> textos = new ArrayList<String>();
	
	//Classe que utiliza FileWriter, para abrir um arquivo e escrever
	public void writeInFile() {
		try{
			//Inicia a gravacao com base no arquivo do diretorio escolhido
           FileWriter fw=new FileWriter(diretorioArquivo);    
           //Chama a funcao gravarPalavras
           gravarPalavaras(fw);
           //fecha o arquivo
           fw.close();    
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Gravado com Sucesso!");    
	}
	
	//Recebe todos os valores do ArrayList e grava no arquivo
	private void gravarPalavaras(FileWriter fw) throws IOException {
		for (String texto : textos) {
			fw.write(texto); 
			//Pula linha
			fw.write(System.getProperty( "line.separator" ));
		}
	}
	
	//Adiciona uma string passada por parametro no ArayList
	public void gravarArrayList(String texto) {
		this.textos.add(texto);
	}

}
