package com.jorge.drogaria.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;

public class HibernateUtil {

	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	public static Connection getConexao() {
		Session sessao = fabricaDeSessoes.openSession();

		Connection conexao = sessao
				.doReturningWork(new ReturningWork<Connection>() {
					@Override
					public Connection execute(Connection conn)
							throws SQLException {
						return conn;
					}
				});

		return conexao;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {

			Configuration configuracao = new Configuration().configure();
			StandardServiceRegistryBuilder registro = new StandardServiceRegistryBuilder()
					.applySettings(configuracao.getProperties());
			SessionFactory fabrica = configuracao.buildSessionFactory(registro
					.build());

			return fabrica;
		} catch (Throwable ex) {
			System.err
					.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
