import React from "react";
import { Card, Col } from "react-bootstrap";
import Image from "react-bootstrap/Image";
import {useNavigate } from "react-router-dom"
import { PRODUCT_ROUTE } from "../utils/consts";


const ProductItem = ({device})=>{

    const history = useNavigate()

    return(
        <Col md={3} className={"mt-5 ml-5"} onClick={()=>history(PRODUCT_ROUTE+'/'+device[0])}>
            <Card style={{width:150, cursor:'pointer'}} border="light">
                <Image width={150} height = {150} src = {device[3]}></Image>
                <div className="mt-1 d-flex justify-content-between align-items-center">
                    <div>{device[1]}</div>
                    <div>{device[2]+'p'}</div>
                </div>
            </Card>
        </Col>
    )
}

export default ProductItem;