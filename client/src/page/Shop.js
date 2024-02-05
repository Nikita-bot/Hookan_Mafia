import React, { useContext, useEffect } from "react";
import {Container } from "react-bootstrap";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import TypeBar from "../components/TypeBar";
import BrandBar from "../components/BrandBar"
import ProductList from "../components/ProductList";
import { observer } from "mobx-react-lite";
import { Context } from "..";
import { fetchBrand, fetchOneProduct, fetchProduct, fetchType } from "../http/productApi";




const Shop = observer(() => {
    const {device} = useContext(Context)
    useEffect(()=>{
        fetchType().then(data => device.setTypes(data))
        fetchBrand().then(data => device.setBrands(data))
        fetchProduct().then(data=>device.setDevices(data)) 
    },[])

    useEffect(()=>{
        fetchProduct(device.selectedType[0],device.selectedBrand[0]).then(data =>{
            device.setDevices(data)
        })
    },[device.selectedType[0],device.selectedBrand[0]])
    return (
        <Container>
            <Row className="mt-2">
                <Col md={3}>
                    <TypeBar/>
                </Col>
                <Col md={9}>
                    <BrandBar/>
                    <ProductList/>
                </Col>

            </Row>
        </Container>
    );
})

export default Shop;