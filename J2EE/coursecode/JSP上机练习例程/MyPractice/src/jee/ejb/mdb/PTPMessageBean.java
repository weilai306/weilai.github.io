package jee.ejb.mdb;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.*;
import javax.annotation.*;
import javax.jms.*;
/**
 * Message-Driven Bean implementation class for: PTPMessageBean
 */
@MessageDriven(activationConfig =  {
		 @ActivationConfigProperty(
                 propertyName = "destinationType", 
                 propertyValue = "javax.jms.Topic"),
      @ActivationConfigProperty(
                 propertyName = "destination", 
                 propertyValue = "/topic/test"),
      @ActivationConfigProperty(
                propertyName = "subscriptionDurability", 
                propertyValue = "Durable"),
      @ActivationConfigProperty(
                propertyName = "clientID", 
                propertyValue = "consumer_a"),
    })

public class PTPMessageBean implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;

    public PTPMessageBean() {
    }

    public void onMessage(Message inMessage) {
        TextMessage msg = null;
        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                System.out.println("��Ϣ����Bean:���յ�����Ϣ " + msg.getText());
            } else {
                System.out.println("��Ϣ�����Ͳ���ȷ�� " + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }

    }
    
}
