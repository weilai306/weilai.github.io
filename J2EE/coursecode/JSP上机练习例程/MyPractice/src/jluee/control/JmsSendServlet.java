package jluee.control;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JmsSendServlet
 */
@WebServlet("/JmsSendServlet")
public class JmsSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(JmsSendServlet.class.getName());

	private static final String DEFAULT_MESSAGE = "Welcome to JMS queue!";
	private static final String DEFAULT_CONNECTION_FACTORY = "/ConnectionFactory";
	private static final String DEFAULT_DESTINATION = "/queue/test";
	private static final String DEFAULT_MESSAGE_COUNT = "1";

	private static final String DEFAULT_USERNAME = "test";
	private static final String DEFAULT_PASSWORD = "123456";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "remote://localhost:4447";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JmsSendServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Context context = null;
		Connection connection = null;
		try {
			// ���������ĵ�JNDI����
			System.out.println("����JNDI���ʻ�����ϢҲ��������Ӧ�÷���������������Ϣ!");
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);// ��KEY��ֵΪ��ʼ��Context�Ĺ�����,JNDI����������
			env.put(Context.PROVIDER_URL, PROVIDER_URL);// ��KEY��ֵΪContext�����ṩ�ߵ�URL.���������ṩ�ߵ�URL
			env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
			env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);// Ӧ���û��ĵ�¼��,����.
			// ��ȡ��InitialContext����.
			context = new InitialContext();
			System.out.println("��ȡ���ӹ���!");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			System.out.println("��ȡĿ�ĵ�!");
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

			// ����JMS���ӡ��Ự�������ߺ�������
			connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			connection.start();

			int count = Integer.parseInt(DEFAULT_MESSAGE_COUNT);
			// �����ض���Ŀ����Ϣ
			TextMessage message = null;
			for (int i = 0; i < count; i++) {
				message = session.createTextMessage(DEFAULT_MESSAGE);
				producer.send(message);
				response.getWriter().append("message:" + message);
				response.getWriter().append("message:" + DEFAULT_MESSAGE);
				System.out.println("message:" + message);
				System.out.println("message:" + DEFAULT_MESSAGE);
			}
			// �ȴ�30���˳�
//			CountDownLatch latch = new CountDownLatch(1);
//			latch.await(30, TimeUnit.SECONDS);

		} catch (Exception exception) {
			log.severe(exception.getMessage());
			exception.printStackTrace();
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// �ر����Ӹ���Ự,�����̺�������
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
