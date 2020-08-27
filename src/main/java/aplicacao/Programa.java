package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

//		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		//aqui ja tenho a conexao com bd e todos os contextos criados
		//exemplo-jpa é o mesmo nome que está la no persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//*******salvar***********
		//Sempre que a operacao nao é uma simples consulta precismaos de uma transacao
		//em.getTransaction().begin();
		
		//salvar no banco de dados
		//em.persist(p1); //pesrsit salva no bd
		//em.persist(p2);
		//em.persist(p3);
		
		//em.getTransaction().commit(); //para encerrar a transacao
		
		//***********consultar bando de dados - consulta e converte em objeto
		//Pessoa p = em.find(Pessoa.class, 2); //encontra o segundo id
		//System.out.println(p);
		
		//apaga do banco de dados somente registro monitorado que é um que acabamos de inserir ou um que ainda nao fechamos o entity manager
		//ou um que acabamos de consultar, como abaixo
		Pessoa p = em.find(Pessoa.class, 5);
		
		//Sempre que a operacao nao é uma simples consulta precismaos de uma transacao
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit(); //para encerrar a transacao
		
		
		System.out.println("Pronto");
		em.close();
		emf.close();
	

	}

}
