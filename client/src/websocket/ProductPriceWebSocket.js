import React, { useContext, useEffect } from 'react';
import { Context } from '..';
import { fetchProduct } from '../http/productApi';

const ProductPriceWebSocket = () => {

    const {device} = useContext(Context)

    useEffect(() => {
        const socket = new WebSocket('ws://localhost:8080/store/price');

        socket.onopen = () => {
        console.log('WebSocket connection opened');
        };

        socket.onmessage = (event) => {
        console.log('WebSocket message received:', event.data);
        fetchProduct().then(data=>device.setDevices(data))
        };

        socket.onclose = () => {
        console.log('WebSocket connection closed');
        };

        socket.onerror = (error) => {
        console.error('WebSocket error:', error);
        };
        return () => {
        socket.close();
        };
    }, []);

};

export default ProductPriceWebSocket;