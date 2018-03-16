package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import model.Pais;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePais{
	Pais pais, copia;
	static int id_pais = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id_pais, "It�lia", 58103033, 301230 );
		copia = new Pais(id_pais, "It�lia", 58103033, 301230 );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id_pais);
	}
	
	@Test
	public void test04Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais(1, "Brasil", 201032714, 8515049);
		Pais novo = new Pais(1, null, -1, -1);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test05Criar() {
		System.out.println("criar");
		pais.criar();
		id_pais = pais.getId();
		System.out.println(id_pais);
		copia.setId(id_pais);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test06Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test07Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		copia.setArea(-1);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais, copia);
	}
	@Test
	public void teste08consultarP() {
		pais.consultarP();
	}
	
	@Test
	public void teste09consultarA() {
		pais.consultarA();
	}
	
	@Test
	public void teste10buscarPaises() {
		pais.buscarPaises();
	}
}