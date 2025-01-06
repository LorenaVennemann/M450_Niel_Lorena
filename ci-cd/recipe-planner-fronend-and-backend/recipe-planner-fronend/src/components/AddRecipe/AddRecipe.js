import React, { useState } from 'react';
import './AddRecipe.css';
import { useForm } from "react-hook-form";
import { Form, Button, Col, Row } from 'react-bootstrap';
import axios from "axios";
import AddIngredient from "../AddIngredient/AddIngredient";

function AddRecipe() {
    const [formData, setFormData] = useState({
        name: '',
        description: '',
        imageUrl: '',
        ingredients: []
    });

    const [listId, setListId] = useState(1);

    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm();

    const addIngredient = () => {
        setFormData(prevState => ({
            ...prevState,
            ingredients: [...prevState.ingredients, { listId, name: '', unit: 'PIECE', quantity: '' }]
        }));
        setListId(listId + 1);
    };

    const updateIngredient = (updatedIngredient) => {
        setFormData(prevState => ({
            ...prevState,
            ingredients: prevState.ingredients.map(ingredient => ingredient.listId === updatedIngredient.listId ? updatedIngredient : ingredient)
        }));
    };

    const removeIngredient = (ingredientToRemove) => {
        setFormData(prevState => ({
            ...prevState,
            ingredients: prevState.ingredients.filter(ingredient => ingredient.listId !== ingredientToRemove.listId)
        }));
    };

    const onSubmit = (data) => {
        const recipeData = {
            ...formData,
            name: data.name,
            description: data.description,
            imageUrl: data.imageUrl
        };

    
        const API_URL = 'http://localhost:8080/api/recipes'; 

        axios.post(API_URL, recipeData)
            .then(response => {
                console.log('Recipe added successfully:', response.data);
            })
            .catch(error => {
                console.error('There was an error adding the recipe:', error);
            });
    };

    return (
        <div className="bg">
            <div className="m-3">
                <h1 className="h3 bg-dark text-bg-primary mt-2">Add Recipe</h1>
                <Form onSubmit={handleSubmit(onSubmit)}>
                    <Form.Group className="mb-1" controlId="formBasicName">
                        <Form.Label>Recipe Name:</Form.Label>
                        <Form.Control 
                            placeholder="Name" 
                            {...register("name", { required: true })}
                        />
                        {errors.name && <span className="text-danger">This field is required</span>}
                    </Form.Group>
                    <Form.Group className="mb-1" controlId="formBasicDescription">
                        <Form.Label>Description:</Form.Label>
                        <Form.Control 
                            placeholder="Description" 
                            {...register("description", { required: true })}
                        />
                        {errors.description && <span className="text-danger">This field is required</span>}
                    </Form.Group>
                    <Form.Group className="mb-1 mb-5" controlId="formBasicImageUrl">
                        <Form.Label>Image URL:</Form.Label>
                        <Form.Control 
                            placeholder="URL" 
                            {...register("imageUrl", { required: true })}
                        />
                        {errors.imageUrl && <span className="text-danger">This field is required</span>}
                    </Form.Group>
                    <Row>
                        <Col>Ingredient</Col>
                        <Col>Unit</Col>
                        <Col>Quantity</Col>
                        <Col xs={1}></Col>
                    </Row>
                    <hr />
                    {formData.ingredients.map(ingredient => (
                        <AddIngredient
                            key={ingredient.listId}
                            ingredient={ingredient}
                            updateIngredient={updateIngredient}
                            removeIngredient={removeIngredient}
                        />
                    ))}
                    <Row className="mt-2">
                        <Button
                            variant='warning'
                            onClick={addIngredient}
                        >Add Ingredient</Button>
                    </Row>
                    <Button variant="primary" type="submit" className="mb-5">
                        Submit
                    </Button>
                </Form>
            </div>
        </div>
    );
}

export default AddRecipe;
