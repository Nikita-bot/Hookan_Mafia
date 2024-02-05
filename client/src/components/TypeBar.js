import { observer } from "mobx-react-lite";
import React, { useContext } from "react";
import { Context } from "..";
import ListGroup from "react-bootstrap/ListGroup"


const TypeBar = observer(() => {
    const {device} = useContext(Context)
    console.log(device.types[0].id)
    return (
    <ListGroup>
      {device.types.map(type => 

        <ListGroup.Item
            style={{cursor:'pointer'}}
            active = {type[0] === device.selectedType[0]}
            onClick={()=>{
                device.setSelectedType(type)
            }}
            key={type[0]}
        >
            {type[1]}
        </ListGroup.Item>
        
        )}
    </ListGroup>
    );
});

export default TypeBar;