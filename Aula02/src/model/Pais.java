package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Pais {
	private int id;
	private String nome_pais;
	private long populacao;
	private double area;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pais(){	
	}
	public Pais(int id, String nome_pais, long populacao, double area) {
		this.setId(id);
		this.setNome(nome_pais);
		this.setPopulacao(populacao);
		this.setArea(area);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome_pais;
	}
	public void setNome(String nome_pais) {
		this.nome_pais = nome_pais;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	} 
	
	// Obtém conexão com o banco de dados
		public static Connection obtemConexao() throws SQLException {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/vendas?user=root&password=xrl18fev");
		}

		public void criar() {
			String sqlInsert = "INSERT INTO pais(nome_pais, populacao, area) VALUES (?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, getNome());
				stm.setLong(2, getPopulacao());
				stm.setDouble(3, getArea());
				stm.execute();
				String sqlQuery  = "SELECT LAST_INSERT_id_pais()";
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
					if(rs.next()){
						setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void atualizar() {
			String sqlUpdate = "UPDATE pais SET nome_pais=?, populacao=?, area=? WHERE id_pais=?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, getNome());
				stm.setLong(2, getPopulacao());
				stm.setDouble(3, getArea());
				stm.setInt(4, getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void excluir() {
			String sqlDelete = "DELETE FROM pais WHERE id_pais = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void carregar() {
			String sqlSelect = "SELECT nome_pais, populacao, area FROM pais WHERE id_pais = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						setNome(rs.getString("nome_pais"));
						setPopulacao(rs.getLong("populacao"));
						setArea(rs.getLong("area"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
		
		public void consultarP() {
			String sqlSelect = "SELECT id_pais, nome_pais, populacao, area FROM pais WHERE populacao = (select MAX(populacao) FROM pais)";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						this.setId(rs.getInt("id_pais"));
						this.setNome(rs.getString("nome_pais"));
						this.setPopulacao(rs.getLong("populacao"));
						this.setArea(rs.getDouble("area"));
						System.out.println("País com maior população [id=" + id + ", nome=" + nome_pais + ", fone=" + populacao + ", area=" + area + "]"); 
					}
			}catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			
		}
		
		public void consultarA() {
			String sqlSelect = "SELECT id_pais, nome_pais, populacao, area FROM pais WHERE area = (select MIN(area) FROM pais)";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						this.setId(rs.getInt("id_pais"));
						this.setNome(rs.getString("nome_pais"));
						this.setPopulacao(rs.getLong("populacao"));
						this.setArea(rs.getDouble("area"));
						System.out.println("País com maior população [id=" + id + ", nome=" + nome_pais + ", fone=" + populacao + ", area=" + area + "]"); 
					}
			}catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
		
		public ArrayList<Pais> buscarPaises(){
			String sqlSelect = "SELECT id_pais, nome_pais, populacao, area FROM pais";
			ArrayList<Pais> lista = new ArrayList<>();
			
			try(Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					Pais pais = new Pais();
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome_pais"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					lista.add(pais);
				}
			}catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista;
		}
}
