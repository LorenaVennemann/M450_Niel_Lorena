import React from 'react';
import PropTypes from 'prop-types';
import './AddIngredient.css';
import { Button, Col, Form, Row } from "react-bootstrap";

const AddIngredient = ({ ingredient, updateIngredient, removeIngredient }) => {
    const handleChange = (field) => (e) => {
        const value = field === 'quantity' ? parseFloat(e.target.value) || 0 : e.target.value;
        updateIngredient({ ...ingredient, [field]: value });
    };

    return (
        <Row>
            <Col>
                <Form.Group className="mb-1" controlId={`formBasicName${ingredient.listId}`}>
                    <Form.Control 
                        placeholder="Name" 
                        value={ingredient.name || ''} 
                        onChange={handleChange('name')}
                    />
                </Form.Group>
            </Col>
            <Col>
                <Form.Group className="mb-1" controlId={`formBasicUnit${ingredient.listId}`}>
                    <Form.Select 
                        value={ingredient.unit} 
                        onChange={handleChange('unit')}
                    >
                        <option value="PIECE">PIECE</option>
                        <option value="GRAMM">GRAMM</option>
                        <option value="KILOGRAMM">KILOGRAMM</option>
                        <option value="LITRE">LITRE</option>
                        <option value="DECILITRE">DECILITRE</option>
                    </Form.Select>
                </Form.Group>
            </Col>
            <Col>
                <Form.Group className="mb-1" controlId={`quantity${ingredient.listId}`}>
                    <Form.Control 
                        placeholder="Quantity" 
                        type="number"
                        value={ingredient.quantity || ''} 
                        onChange={handleChange('quantity')}
                    />
                </Form.Group>
            </Col>
            <Col xs={1}>
                <Button
                    onClick={() => removeIngredient(ingredient)}
                    variant='outline-dark'
                    className="mb-1"
                >x</Button>
            </Col>
        </Row>
    );
};

AddIngredient.propTypes = {
    ingredient: PropTypes.shape({
        listId: PropTypes.number.isRequired,
        name: PropTypes.string,
        unit: PropTypes.string,
        quantity: PropTypes.oneOfType([PropTypes.string, PropTypes.number])
    }).isRequired,
    updateIngredient: PropTypes.func.isRequired,
    removeIngredient: PropTypes.func.isRequired
};

export default AddIngredient;
