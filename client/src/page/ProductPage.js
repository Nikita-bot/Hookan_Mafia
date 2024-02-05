
import { useContext, useEffect, useState } from "react";
import { Button, Card, Col, Container, Image, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { fetchOneProduct } from "../http/productApi";
import { Context } from "..";


const ProductPage = () => {
    const {device} = useContext(Context)
    const {id} = useParams()

    return (
        <Container className="mt-4">
            <Row>
                <Col md={4}>
                    <Image width={200} height = {200} src = {device.devices[id-1][3]}></Image>
                </Col>
                <Col md={4}>
                    <Row className="d-flex flex-column align-items-center">
                        <h2>{device.devices[id-1][1]}</h2>
                        <h2>Крепость: {device.devices[id-1][6]}</h2>
                    </Row>
                </Col>
                <Col md={4}>
                    <Card>
                        <h2>Цена: {device.devices[id-1][2]}</h2>
                        <Button variant={"outline-dark"}>Добавить в корзину</Button>
                    </Card>
                    
                </Col>
            </Row>
            <Row>
                <h2>Описание:</h2>
                {device.devices[id-1][7]}
            </Row>
            
        </Container>
    );
}

export default ProductPage;