const express = require('express')
const controller = require('../controllers/profile')
const upload = require('../middleware/upload')
const passport = require('passport')
const router = express.Router()


router.patch('/update',passport.authenticate('jwt', {session: false}), upload.single('image'), controller.update)

module.exports = router