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
                active = {brand[0] === device.selectedBrand[0]}
                onClick={()=>{
                    device.setSelectedBrand(brand)
                }}
                key={brand[0]}>
                    {brand[1]}
                </ListGroup.Item>
            )}
        </ListGroup>
    );
});

export default BrandBar;