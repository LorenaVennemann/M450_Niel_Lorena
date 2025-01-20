import React from 'react';
import PropTypes from 'prop-types';
import './AddIngredient.css';
import {Button, Col, Form, Row} from "react-bootstrap";

const AddIngredient = ({ingredients, ingredient, updateIngredient, removeIngredient}) => {

    console.log(ingredient);

    return (
        <Row>
            <Col>
                <Form.Group className="mb-1" controlId="formBasicName">
                    <Form.Control
                        placeholder="Name"
                        value={ingredient.name}
                        onChange={(e) => updateIngredient({...ingredient, name: e.target.value})}
                    />
                </Form.Group>
            </Col>
            <Col>
                <Form.Group className="mb-1" controlId="formBasicUnit">
                    <Form.Select
                        value={ingredient.unit}
                        onChange={(e) => updateIngredient({...ingredient, unit: e.target.value})}
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
                <Form.Group className="mb-1" controlId="quantity">
                    <Form.Control
                        placeholder="Quantity"
                        value={ingredient.amount}
                        onChange={(e) => updateIngredient({...ingredient, amount: e.target.value})}
                    />
                </Form.Group>
            </Col>
            <Col xs={1}>
                <Button
                    onClick={e => removeIngredient(ingredient)}
                    variant='outline-dark'
                    className="mb-1"
                >x</Button>
            </Col>
        </Row>
    );
};

AddIngredient.propTypes = {
    ingredients: PropTypes.array.isRequired,
    ingredient: PropTypes.object.isRequired,
    updateIngredient: PropTypes.func.isRequired,
    removeIngredient: PropTypes.func.isRequired
};

AddIngredient.defaultProps = {};

export default AddIngredient;
