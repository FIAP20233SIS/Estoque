package br.com.fiap.estoque.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe utilitária para facilitar o registro de logs em diferentes níveis de
 * severidade do projeto.
 */
public class LoggingModule {

	private static final Logger logger = LoggerFactory.getLogger(LoggingModule.class);

	/**
	 * Registra uma mensagem de log de informação.
	 * 
	 * @param message A mensagem de log a ser registrada.
	 */
	public static void info(String message) {
		logger.info(message);
	}

	/**
	 * Registra uma mensagem de log de aviso.
	 * 
	 * @param message A mensagem de log a ser registrada.
	 */
	public static void warn(String message) {
		logger.warn(message);
	}

	/**
	 * Registra uma mensagem de log de erro.
	 * 
	 * @param message A mensagem de log a ser registrada.
	 */
	public static void error(String message) {
		logger.error(message);
	}

	/**
	 * Registra uma mensagem de log de erro juntamente com uma exceção.
	 * 
	 * @param message   A mensagem de log a ser registrada.
	 * @param throwable A exceção a ser registrada no log.
	 */
	public static void error(String message, Throwable throwable) {
		logger.error(message, throwable);
	}
}
