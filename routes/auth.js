const express = require('express')
const controller = require('../controllers/auth')
const upload = require('../middleware/upload')
const router = express.Router()

// localhost:6000/api/auth/login
router.post('/login', controller.login)

// localhost:6000/api/auth/register
router.post('/register', upload.single('image'), controller.register)


module.exports = router