package com.nmictech.mycomposeproject.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nmictech.mycomposeproject.R
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun TabsScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Full-screen background image
        Image(
            painter = painterResource(id = R.drawable.home_image), // Replace with your background image resource
            contentDescription = "Full Screen Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(start = 112.dp, top = 56.dp)
        ) {
            HeaderWithFollowingLayout()
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp), verticalArrangement = Arrangement.Bottom
        ) {
            ProfileAndFollowsLayout()

            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(390.dp)
                    .padding(start = 12.dp)
            ) {

                CustomText(
                    text = "Another day, another beach. I want to leave like\n" + "this forever #travel #nature #ocean",
                    fontSize = 14.sp, // Dynamic font size
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Circular image

                Row(
                    modifier = Modifier
                        .height(32.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White.copy(alpha = 0.16f)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cd_small), // Replace with your circular image resource
                        contentDescription = "Circular Image",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(8.dp)
                    )
                    CustomText(
                        text = "eat-Con you kiss For", fontSize = 13.sp, // Dynamic font size
                        fontWeight = FontWeight.W400, lineHeight = 20.sp
                    )

                }

                Row(
                    modifier = Modifier
                        .height(32.dp)
                        .width(72.dp)
                        .padding(start = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(colorResource(R.color.pink)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heart_small), // Replace with your circular image resource
                        contentDescription = "Circular Image",
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 2.dp)

                    )
                    CustomText(
                        text = "999K", fontSize = 13.sp, // Dynamic font size
                        fontWeight = FontWeight.W400, lineHeight = 20.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .height(32.dp)
                        .width(72.dp)
                        .padding(start = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White.copy(alpha = 0.26f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.comments_small), // Replace with your circular image resource
                        contentDescription = "Circular Image",
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 2.dp)
                    )
                    CustomText(
                        text = "999K", fontSize = 13.sp, // Dynamic font size
                        fontWeight = FontWeight.W400, lineHeight = 20.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .padding(start = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White.copy(alpha = 0.26f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.share_small), // Replace with your circular image resource
                        contentDescription = "Circular Image", modifier = Modifier.size(16.dp)
                    )
                }


            }


        }
    }
}


@Composable
fun ProfileAndFollowsLayout() {
    ConstraintLayout {
        val (profileImage, profileName, verificationImage, follow) = createRefs()
        // Place a Text composable
        Image(
            painter = painterResource(id = R.drawable.story), // Replace with your circular image resource
            contentDescription = "Circular Image",
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .constrainAs(profileImage) {
                    start.linkTo(parent.start, margin = 12.dp)
                }

        )
        CustomText(
            text = "travelguru", modifier = Modifier
                .width(85.dp)
                .constrainAs(profileName) {
                    start.linkTo(parent.start, margin = 60.dp)
                    top.linkTo(profileImage.top)
                    bottom.linkTo(profileImage.bottom)
                }, fontSize = 17.sp, // Dynamic font size
            fontWeight = FontWeight.W600
        )

        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color = colorResource(R.color.greenBlue))
                .constrainAs(verificationImage) {
                    start.linkTo(parent.start, margin = 149.dp)
                    top.linkTo(profileImage.top)
                    bottom.linkTo(profileImage.bottom)
                }) {
            Image(
                painter = painterResource(id = R.drawable.vector), // Replace with your circular image resource
                contentDescription = "Circular Image",
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(16.dp)
                    .width(16.dp)

            )
        }
        Box(
            modifier = Modifier
                .height(20.dp)
                .width(53.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = colorResource(R.color.pink))
                .constrainAs(follow) {
                    start.linkTo(parent.start, margin = 185.dp)
                    top.linkTo(profileImage.top)
                    bottom.linkTo(profileImage.bottom)
                }) {

            CustomText(
                text = "Follow",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 12.sp, // Dynamic font size
                fontWeight = FontWeight.W500
            )

        }
    }
}

@Composable
fun HeaderWithFollowingLayout() {
    ConstraintLayout() {
        val (following, circle, divider, forYou) = createRefs()


        CustomText(
            text = "Following",
            modifier = Modifier.constrainAs(following) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(parent.top)

            },
            fontSize = 16.sp, // Dynamic font size
            fontWeight = FontWeight.W600,
        )


        // Small circular indicator placed to the right of "Following"
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = colorResource(id = R.color.pink))
                .constrainAs(circle) {
                    start.linkTo(following.end, margin = 4.dp)
                    top.linkTo(following.top)
                })

        // Vertical divider placed after the circular indicator
        Divider(
            modifier = Modifier
                .width(2.dp)
                .height(12.dp)
                .constrainAs(divider) {
                    start.linkTo(circle.end, margin = 8.dp)
                    top.linkTo(following.top)
                    bottom.linkTo(following.bottom)
                })

        // "For You" TextView placed after the divider
        CustomText(
            text = "For You",
            modifier = Modifier.constrainAs(forYou) {
                start.linkTo(divider.end, margin = 8.dp)
                top.linkTo(parent.top)
            },
            fontSize = 16.sp, // Dynamic font size
            fontWeight = FontWeight.W600,
        )
    }
}


@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.W500,
    lineHeight: TextUnit = 16.sp
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        lineHeight = lineHeight,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Start,
        modifier = modifier
    )
}










