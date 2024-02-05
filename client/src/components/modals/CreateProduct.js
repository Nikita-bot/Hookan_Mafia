import React, { useContext, useState, useEffect } from "react";
import { Form, Modal, Button, Dropdown } from "react-bootstrap";
import { Context } from "../..";
import { observer } from "mobx-react-lite";
import { createProduct, fetchBrand, fetchOneProduct, fetchProduct, fetchType } from "../../http/productApi";


const CreateProduct = observer(({show, onHide}) =>{
    const {device} = useContext(Context)
    
    const [name,setName] = useState('')
    const [price,setPrice] = useState('')
    const [description,setDescription] = useState('')
    const [strength,setStrength] = useState('')
    const img = "https://burntobacco.com/wp-content/uploads/2021/11/BlackBurn-pachka.png"

    useEffect(()=>{
        fetchType().then(data => device.setTypes(data))
        fetchBrand().then(data => device.setBrands(data)) 
    },[])

    const addProduct =()=>{
        createProduct({name:name, price:price, img:img, type_id:device.selectedType[0], brand_id:device.selectedBrand[0], strength:strength,description:description}).then(
            data=>{alert(data); onHide()}
        )
    }


    return (
        <Modal
            show = {show}
            onHide={onHide}
            size="lg"
            centered
            >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Добавить новый бренд
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
               <Form>
                    <Dropdown className="mt-4">
                        <Dropdown.Toggle>{device.selectedType[1]||"Выберите тип"}</Dropdown.Toggle>
                        <Dropdown.Menu>
                            {device.types.map(type=>
                                <Dropdown.Item onClick={()=>device.setSelectedType(type)} key={type[0]}>{type[1]}</Dropdown.Item>
                            )}
                        </Dropdown.Menu>
                    </Dropdown >
                    <Dropdown className="mt-4">
                        <Dropdown.Toggle>{device.selectedBrand[1]||"Выберите бренд"}</Dropdown.Toggle>
                        <Dropdown.Menu>
                            {device.brands.map(brand=>
                                <Dropdown.Item onClick={()=>device.setSelectedBrand(brand)} key={brand[0]}>{brand[1]}</Dropdown.Item>
                            )}
                        </Dropdown.Menu>
                    </Dropdown>
                    <Form.Control
                        value={name}
                        onChange={e=>setName(e.target.value)}
                        className="mt-4"
                        placeholder="Введите название"
                    />
                    <Form.Control
                        value={description}
                        onChange={e=>setDescription(e.target.value)}
                        className="mt-4"
                        placeholder="Введите описание"
                    />
                    <Form.Control
                        value={strength}
                        onChange={e=>setStrength(e.target.value)}
                        className="mt-4"
                        placeholder="Введите крепость"
                        type="number"
                    />
                    <Form.Control
                        value={price}
                        onChange={e=>setPrice(e.target.value)}
                        className="mt-4"
                        placeholder="Введите стоимость"
                        type="number"
                    />

                    

               </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant ="outline-danger" onClick={addProduct}>Добавить</Button>
                <Button variant ="outline-success" onClick={onHide}>Закрыть</Button>
            </Modal.Footer>
        </Modal>
    );
});

export default CreateProduct;