import './Recipe.css';
import { Button, Card } from "react-bootstrap";
import React, { useState } from "react";
import axios from "axios";

function Recipe(props) {
    const [isEditing, setIsEditing] = useState(false);
    const [updatedRecipe, setUpdatedRecipe] = useState({
        name: props.title,
        description: props.description,
        imageUrl: props.image
    });

    const handleEditClick = () => {
        setIsEditing(true);
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setUpdatedRecipe({ ...updatedRecipe, [name]: value });
    };

    const handleSaveClick = () => {
        console.log("Updating recipe with ID:", props.id); 
        if (props.id) {
            axios.put(`http://localhost:8080/api/recipes/recipe/${props.id}`, updatedRecipe)
                .then(response => {
                    console.log("Recipe updated:", response.data);
                    setIsEditing(false);
                })
                .catch(error => {
                    console.error("There was an error updating the recipe:", error);
                });
        } else {
            console.error("Recipe ID is missing!");
        }
    };
    

    return (
        <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src={props.image} />
            <Card.Body>
                <Card.Title>{isEditing ? 
                    <input 
                        type="text" 
                        name="name" 
                        value={updatedRecipe.name} 
                        onChange={handleInputChange} /> 
                    : props.title}
                </Card.Title>

                {isEditing ? 
                    <textarea 
                        name="description" 
                        value={updatedRecipe.description} 
                        onChange={handleInputChange} />
                    : props.description}

                <Button variant="primary" onClick={isEditing ? handleSaveClick : handleEditClick}>
                    {isEditing ? 'Save Details' : 'Edit Details'}
                </Button>
            </Card.Body>
        </Card>
    );
}

export default Recipe;
