import React, { useState, useEffect } from 'react';
import './AddRecipe.css';
import { Form, Button, Col, Row } from 'react-bootstrap';
import axios from "axios";

import AddIngredient from "../components/AddIngredient/AddIngredient";

const baseURL = "http://localhost:8080/api/recipes";

function AddRecipe() {
    const [ingredients, setIngredients] = useState([]);
    const [formData, setFormData] = useState({
        "name": '',
        "description": '',
        "imageUrl": '',
        "ingredients": [],
        "id": null
    });
    const [loading, setLoading] = useState(true);
    const [listId, setListId] = useState(1);

    const id  = localStorage.getItem("id") 

    useEffect(() => {
        const fetchRecipe = async () => {
            try {
                const response = await axios.get(`${baseURL}/recipe/${id}`);
                setFormData({
                    "name": response.data.name,
                    "description": response.data.description,
                    "imageUrl": response.data.imageUrl,
                    "ingredients": response.data.ingredients || [],
                    "id": response.data.id
                });
                console.log(response.data)
                setIngredients(response.data,ingredients || [])

                setLoading(false); // Setze den Ladezustand auf false, wenn die Daten geladen sind
            } catch (error) {
                console.error('Error fetching recipe:', error);
                setLoading(false); // Setze den Ladezustand auf false, auch im Fehlerfall
            }
        };

        if (id) {
            fetchRecipe();
        }
    }, [id]);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch(baseURL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                const data = await response.json();
                console.log('Erfolgreich:', data);
            } else {
                console.error('Fehler beim Senden der Anfrage');
            }
        } catch (error) {
            console.error('Netzwerkfehler:', error);
        }
    };

    const addIngredient = () => {
        setFormData(({...formData, ingredients: [
            ...formData.ingredients, {
                listId: listId,
                ingredient: '',
                unit: 'PIECE',
                quantity: ''
            }
        ]}));
        setListId(listId + 1);
    };

    const updateIngredient = (ingredientObj) => {
        const updatedIngredients = formData.ingredients.map((ingredient) => {
            if (ingredient.listId === ingredientObj.listId) {
                return ingredientObj;
            }
            return ingredient;
        });
        setFormData({...formData, ingredients: updatedIngredients});
    };

    const removeIngredient = (ingredientObj) => {
        const updatedIngredients = formData.ingredients.filter((ingredient) => ingredient.listId !== ingredientObj.listId);
        setFormData({...formData, ingredients: updatedIngredients});
    };

    useEffect(() => {
        renderIngredients = formData.ingredients.map((ingredient) => (
            <AddIngredient
                key={ingredient.listId}
                ingredient={ingredient}
                ingredients={ingredients}
                listId={listId - 1}
                updateIngredient={updateIngredient}
                removeIngredient={removeIngredient}
            />
        ));    
    },[setLoading])

    let renderIngredients = formData.ingredients.map((ingredient) => (
        <AddIngredient
            key={ingredient.listId}
            ingredient={ingredient}
            ingredients={ingredients}
            listId={listId - 1}
            updateIngredient={updateIngredient}
            removeIngredient={removeIngredient}
        />
    ));

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <>
        <div className="bg">
            <div className="m-3">
                <h1 className="h3 bg-dark text-bg-primary mt-2">Edit Recipe</h1>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-1" controlId="formBasicName">
                        <Form.Label>Recipe Name:</Form.Label>
                        <Form.Control
                            placeholder="Name"
                            name="name"
                            value={formData.name}
                            onChange={handleInputChange}
                        />
                    </Form.Group>

                    <Form.Group className="mb-1" controlId="formBasicDescription">
                        <Form.Label>Description:</Form.Label>
                        <Form.Control
                            placeholder="Description"
                            name="description"
                            value={formData.description}
                            onChange={handleInputChange}
                        />
                    </Form.Group>

                    <Form.Group className="mb-1 mb-5" controlId="formBasicImageUrl">
                        <Form.Label>Image URL:</Form.Label>
                        <Form.Control
                            placeholder="URL"
                            name="imageUrl"
                            value={formData.imageUrl}
                            onChange={handleInputChange}
                        />
                    </Form.Group>

                    <Row>
                        <Col>Ingredient</Col>
                        <Col>Unit</Col>
                        <Col>Quantity</Col>
                        <Col xs={1}></Col>
                    </Row>
                    <hr />
                    <Row>
                        <br></br>
                    </Row>
                    {renderIngredients}
                    <Row>
                        <br></br>
                        <Button
                            variant='warning'
                            onClick={addIngredient}
                            className="mt-1"
                        >
                            Add Ingredient
                        </Button>
                    </Row>
                    <Button variant="primary" type="submit" className="mb-5">
                        Submit
                    </Button>
                </Form>
            </div>
        </div>
        </>
    );
}

export default AddRecipe;
