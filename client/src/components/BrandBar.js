import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Context } from "..";
import ListGroup from "react-bootstrap/ListGroup"


const BrandBar = observer(() => {
    const {device} = useContext(Context)

    return (
        <ListGroup horizontal>
            {device.brands.map(brand=>
               <ListGroup.Item
                style={{cursor:'pointer'}}
                active = {brand.id === device.selectedBrand.id}
                onClick={()=>{
                    device.setSelectedBrand(brand)
                }}
                key={brand.id}>
                    {brand.name}
                </ListGroup.Item>
            )}
        </ListGroup>
    );
});

export default BrandBar;