import React, { useEffect, useState } from 'react';
import './Browse.css';
import axios from 'axios';
import Recipe from '../Recipe/Recipe';
import { Col, Row } from 'react-bootstrap';

const baseURL = "http://localhost:8080/api/recipes";

const Browse = () => {
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get(baseURL)
            .then((response) => {
                setPosts(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.error("There was an error fetching the data!", error);
                setError(error);
                setLoading(false);
            });
    }, []);

    const handleRecipeUpdated = (updatedRecipe) => {
        setPosts((prevPosts) =>
            prevPosts.map((post) =>
                post.id === updatedRecipe.id ? updatedRecipe : post
            )
        );
    };

    if (loading) return <div>Loading...</div>;
    if (error) return <div>There was an error loading the data. Please try again later.</div>;

    return (
        <Row>
            {posts.map((d) => (
                <Col key={d.id} sm={12} md={6} lg={4} xl={3}>
                    <Recipe
                        id={d.id}
                        title={d.name}
                        description={d.description}
                        image={d.imageUrl}
                    />
                </Col>
            ))}
        </Row>
    );
};

export default Browse;
