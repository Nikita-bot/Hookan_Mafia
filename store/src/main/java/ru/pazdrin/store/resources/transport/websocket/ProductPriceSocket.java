/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.transport.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author nikit
 */
@ServerEndpoint("/price")
public class ProductPriceSocket {
    private static Set<Session> sessions = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Open WebSocked:");
        sessions.add(session);
        // Handle when a new WebSocket connection is established
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // Handle WebSocket messages from clients
        System.out.println("Message receiver, " + message);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        // Handle when a WebSocket connection is closed
    }

    @OnError
    public void onError(Throwable error) {
        // Handle WebSocket errors
    }
    
    public static void notifyClients(){
        for (Session session : sessions) {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText("PriceUpdated");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
     
    }
    
}
