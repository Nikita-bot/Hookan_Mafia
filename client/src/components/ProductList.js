import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Row } from "react-bootstrap";
import ProductItem from "./ProductItem";
import { Context } from "..";

const ProductList = observer(() => {
    const {device} = useContext(Context)
    console.log(device.devices)
    return(
        <Row className="d-flex">
            {
               device.devices.map(device =>
                    <ProductItem key={device[0]} device={device}/>
                )
            }
        </Row>
    );

});

export default ProductList;